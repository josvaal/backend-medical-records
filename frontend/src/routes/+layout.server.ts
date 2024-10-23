import { redirect } from '@sveltejs/kit';

/** @type {import('./$types').LayoutServerLoad} */
export async function load({ cookies, route }) {
    const routes: string[] = ["/login", "/create-account"]
    const token = cookies.get("token");
    if (!token) {
        if (!route.id || !routes.includes(route.id)) {
            throw redirect(303, "/login");
        }
    }
}