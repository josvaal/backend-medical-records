<script lang="ts">
	import Icon from '@iconify/svelte';
	import { fly } from 'svelte/transition';

	export let path: string;
	export let text: string;
	export let icon: string;
	export let iconSize: number;
	export let isCurrent: boolean;
</script>

<li class="relative px-6 py-3">
	{#if isCurrent}
		<span
			class="absolute inset-y-0 left-0 w-1 rounded-tr-lg rounded-br-lg bg-purple-600"
			aria-hidden="true"
			in:fly={{ x: -20, duration: 300 }}
			out:fly={{ x: -20, duration: 300 }}
		/>
	{/if}

	<a
		class="inline-flex w-full items-center text-sm font-semibold text-gray-800 transition-colors duration-150 hover:text-gray-800 dark:text-gray-100 dark:hover:text-gray-200"
		href={path}
	>
		<Icon {icon} font-size={iconSize} />
		<span class="ml-4 text-sm">{text}</span>
	</a>
</li>
