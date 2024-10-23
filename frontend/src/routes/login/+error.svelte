<script lang="ts">
	import { page } from '$app/stores';
	import { onDestroy, onMount } from 'svelte';
	let interval: NodeJS.Timeout | null = null;

	interface ValidationError extends Error {
		errors: string[];
	}

	const errors = $page.error as ValidationError;

	let countdown = 5;

	onMount(() => {
		if (errors) {
			interval = setInterval(() => {
				if (countdown > 0) {
					countdown--;
				}
			}, 1000);
		}
	});

	const handleBack = () => {
		window.location.href = '/login';
	};

	$: if (countdown === 0) {
		window.location.href = '/login';
	}

	onDestroy(() => {
		if (interval) {
			clearInterval(interval);
		}
	});
</script>

<div class="flex flex-col min-h-screen items-center bg-gray-50 p-6 dark:bg-gray-900">
	<h1 class="text-2xl">Error {$page.status}</h1>

	<p class="text-xl">Redirigiendo en {countdown}s...</p>
	<button
		on:click={handleBack}
		class="mt-4 block rounded-lg border border-transparent bg-purple-600 px-4 py-2 text-center text-sm font-medium leading-5 text-white transition-colors duration-150 hover:bg-purple-700 focus:outline-none focus:ring-[3px] focus:ring-purple-200 active:bg-purple-600"
		>Volver</button
	>
	<h2 class="text-lg mt-5">Errores:</h2>
	<br />
	{#if errors?.errors}
		<ul class="list-decimal">
			{#each errors.errors as error}
				<li>{error}</li>
			{/each}
		</ul>
	{/if}
</div>
