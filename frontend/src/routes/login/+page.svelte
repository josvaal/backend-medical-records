<script lang="ts">
	import ContentPagesLogin from './ContentPagesLogin.svelte';

	let isDark: boolean = false;

	if (typeof window !== 'undefined') {
		const darkThemeValue = localStorage.getItem('isDarkTheme');
		console.log(darkThemeValue);

		isDark = darkThemeValue === 'true';
	}
</script>

<div class={isDark ? 'dark' : ''}>
	<ContentPagesLogin />
</div>
