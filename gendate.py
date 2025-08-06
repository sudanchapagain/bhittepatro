import json
import sys
from pathlib import Path

def sanitize_event(event_str):
    return [e.strip() for e in event_str.split('|') if e.strip()]

def generate_kotlin_map(data, year):
    months_map = {}

    for month_idx, month in enumerate(data, start=1):
        entries = []
        for day in month:
            events = sanitize_event(day.get("events", ""))
            if not events:
                continue

            bs = day["bs"]
            tithi = day.get("tithi", "")
            holiday = "true" if day.get("holiday") else "false"
            events_kotlin = ', '.join(f'"{e}"' for e in events)

            entry = f"""        EventEntry(
            bs = "{bs}",
            tithi = "{tithi}",
            holiday = {holiday},
            events = listOf({events_kotlin})
        )"""
            entries.append(entry)

        if entries:
            months_map[month_idx] = entries

    kotlin_lines = [
        "val eventsByMonth: Map<Int, List<EventEntry>> = mapOf("
    ]

    for month, entries in months_map.items():
        kotlin_lines.append(f"    {month} to listOf(")
        for i, entry in enumerate(entries):
            if i < len(entries) - 1:
                kotlin_lines.append(entry + ",")
            else:
                kotlin_lines.append(entry)
        kotlin_lines.append("    ),")

    kotlin_lines.append(")")
    return "\n".join(kotlin_lines)

def main():
    if len(sys.argv) != 3:
        print("usage: python gendate.py <json.json> <output.kt>")
        sys.exit(1)

    input_file = Path(sys.argv[1])
    output_file = Path(sys.argv[2])
    year = input_file.stem

    with input_file.open("r", encoding="utf-8") as f:
        data = json.load(f)

    kotlin_code = generate_kotlin_map(data, year)

    with output_file.open("w", encoding="utf-8") as f:
        f.write(kotlin_code)

    print(f"written to {output_file}")

if __name__ == "__main__":
    main()
