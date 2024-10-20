<script lang="ts">
	import { page } from '$app/stores';
	import { menuItems } from '$lib/sidebarItems';
	import { fly } from 'svelte/transition';
	import SidebarItem from './SidebarItem.svelte';

	interface MobileSideMenuProps {
		isPagesMenuOpen: boolean;
	}

	const normalizePath = (path: string) => path.replace(/\/$/, '').toLowerCase();
	$: currentPath = normalizePath($page.url.pathname);
	export let props: MobileSideMenuProps;
</script>

<!-- Backdrop -->
<div
	class="fixed inset-0 z-10 flex items-end bg-black bg-opacity-50 sm:items-center sm:justify-center"
/>
<aside
	class="fixed inset-y-0 z-20 mt-16 w-64 flex-shrink-0 overflow-y-auto bg-white dark:bg-gray-800 md:hidden"
	in:fly|global={{ x: -200, duration: 200 }}
	out:fly|global={{ x: -200, duration: 100 }}
>
	<div class="py-4 text-gray-500 dark:text-gray-400">
		<!-- svelte-ignore a11y-invalid-attribute -->
		<a class="ml-6 text-lg font-bold text-gray-800 dark:text-gray-200" href="/">MediPlus</a>
		<ul class="mt-6">
			{#each menuItems as { icon, iconSize, path, text }}
				<SidebarItem
					{icon}
					{iconSize}
					{path}
					{text}
					isCurrent={normalizePath(path) === currentPath}
				/>
			{/each}
		</ul>
	</div>
</aside>
