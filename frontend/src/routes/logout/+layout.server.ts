import { redirect } from '@sveltejs/kit';

/** @type {import('./$types').LayoutServerLoad} */
export async function load({ cookies }) {
    cookies.delete("token")
    throw redirect(303, "/login");
}