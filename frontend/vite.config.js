import { defineConfig, loadEnv } from "vite";
import preact from "@preact/preset-vite";
import svgr from "vite-plugin-svgr";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [preact(), svgr()],
  server: {
    host: "localhost",
    port: 3000,
    cors: true,
  },
});
