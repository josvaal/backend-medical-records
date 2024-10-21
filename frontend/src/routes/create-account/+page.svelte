<script lang="ts">
	import ContentPagesCreateAccount from './ContentPagesCreateAccount.svelte';

	let isDark: boolean = false;

	if (typeof window !== 'undefined') {
		const darkThemeValue = localStorage.getItem('isDarkTheme');
		console.log(darkThemeValue);

		isDark = darkThemeValue === 'true';
	}
</script>

<div class={isDark ? 'dark' : ''}>
	<ContentPagesCreateAccount />
</div>
