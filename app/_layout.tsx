import { Stack } from "expo-router";
import { Text } from "react-native";
import { useFonts } from "expo-font";

export default function RootLayout() {
  const [fontsLoaded] = useFonts({
    "inter-black": require("../assets/fonts/inter-black.ttf"),
    "inter-bold": require("../assets/fonts/inter-bold.ttf"),
  });

  if (!fontsLoaded) {
    return <Text>Loading...</Text>;
  }

  return <Stack screenOptions={{ headerShown: false }} />;
}
