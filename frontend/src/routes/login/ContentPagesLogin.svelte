<script>
	import { enhance } from '$app/forms';
	import Icon from '@iconify/svelte';
</script>

<svelte:head>
	<title>Iniciar Sesión</title>
</svelte:head>

<div class="flex min-h-screen items-center bg-gray-50 p-6 dark:bg-gray-900">
	<div
		class="mx-auto h-full max-w-4xl flex-1 overflow-hidden rounded-lg bg-white shadow-xl dark:bg-gray-800"
	>
		<div class="flex flex-col overflow-y-auto md:flex-row">
			<div class="h-32 md:h-auto md:w-1/2">
				<img
					aria-hidden="true"
					class="h-full w-full object-cover dark:hidden"
					src="/assets/img/login-office.jpeg"
					alt="Office"
				/>
				<img
					aria-hidden="true"
					class="hidden h-full w-full object-cover dark:block"
					src="/assets/img/login-office-dark.jpeg"
					alt="Office"
				/>
			</div>
			<div class="flex items-center justify-center p-6 sm:p-12 md:w-1/2">
				<div class="w-full">
					<h1 class="mb-4 text-xl font-semibold text-gray-700 dark:text-gray-200">
						Iniciar Sesión
					</h1>
					<form method="post" use:enhance>
						<label class="block text-sm">
							<span class="text-gray-700 dark:text-gray-400">Correo</span>
							<input
								name="email"
								class="form-input mt-1 block w-full rounded-md border-gray-300 text-sm focus:border-purple-400 focus:outline-none focus:ring-[3px] focus:ring-purple-200 dark:border-gray-600 dark:bg-gray-700 dark:text-gray-300 dark:focus:ring-gray-500"
								placeholder="tucorreo@email.com"
								type="email"
								required
							/>
						</label>
						<label class="mt-4 block text-sm">
							<span class="text-gray-700 dark:text-gray-400">Contraseña</span>
							<input
								name="password"
								class="form-input mt-1 block w-full rounded-md border-gray-300 text-sm focus:border-purple-400 focus:outline-none focus:ring-[3px] focus:ring-purple-200 dark:border-gray-600 dark:bg-gray-700 dark:text-gray-300 dark:focus:ring-gray-500"
								placeholder="***************"
								type="password"
								required
							/>
						</label>

						<button
							type="submit"
							class="mt-4 block w-full rounded-lg border border-transparent bg-purple-600 px-4 py-2 text-center text-sm font-medium leading-5 text-white transition-colors duration-150 hover:bg-purple-700 focus:outline-none focus:ring-[3px] focus:ring-purple-200 active:bg-purple-600"
						>
							Iniciar sesión
						</button>
					</form>

					<hr class="my-8" />

					<button
						class="cursor-not-allowed rounded-lg border border-transparent bg-gray-500 px-4 py-2 text-sm font-medium leading-5 opacity-50 transition-colors duration-150 focus:outline-none flex w-full items-center justify-center border-gray-700 text-gray-700 hover:border-gray-500 focus:border-gray-500 focus:ring-gray-500 active:bg-transparent active:text-gray-500 dark:text-gray-400"
						type="button"
						disabled
					>
						<Icon icon="uim:google" font-size="20" />
						&nbsp; Google
					</button>

					<p class="mt-4">
						<a
							class="text-sm font-medium text-purple-600 hover:underline dark:text-purple-400"
							href="/forgot-password"
						>
							¿Olvidaste tu contraseña?
						</a>
					</p>
					<p class="mt-1">
						<a
							class="text-sm font-medium text-purple-600 hover:underline dark:text-purple-400"
							href="/create-account"
						>
							Crear cuenta
						</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
