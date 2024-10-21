import { authLogin } from '$lib/database/auth.js';
import { error } from '@sveltejs/kit';

/** @type {import('./$types').PageServerLoad} */
export async function load({ params }) {
    // const post = await authLogin("string", "string");

    // if (post) {
    //     return post;
    // }

    error(404, 'Not found');
}