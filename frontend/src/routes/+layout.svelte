<script lang="ts">
	import '../app.css';

	import { loadIcons } from '@iconify/svelte';

	loadIcons(['lets-icons:home-duotone', 'solar:user-bold-duotone', 'solar:calendar-bold-duotone']);

	// export let data;
	// console.log(data);
</script>

<slot />
