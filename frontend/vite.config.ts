import { sveltekit } from '@sveltejs/kit/vite';
import { defineConfig } from 'vitest/config';

export default defineConfig({
	plugins: [sveltekit()],
	test: {
		include: ['src/**/*.{test,spec}.{js,ts}']
	},
	resolve: {
		dedupe: ["@fullcalendar/core"],
	},
	optimizeDeps: {
		include: ["@fullcalendar/core", "@fullcalendar/daygrid", "@fullcalendar/interaction", "@fullcalendar/timegrid"],
	}
});
