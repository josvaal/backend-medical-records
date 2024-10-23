import { authLogin, authRegister } from '$lib/database/auth.js';
import { redirect, error } from '@sveltejs/kit';

/** @type {import('./$types').Actions} */
export const actions = {
    default: async ({ request, cookies }) => {
        const formData = await request.formData();

        const { isValid, errors } = verifyData(formData)

        if (isValid) {
            const data = await authLogin(
                formData.get("email")?.toString() ?? "",
                formData.get("password")?.toString() ?? ""
            );
            if (data.object == null) {
                const validationError = new Error('Validation error');
                (validationError as any).errors = [data.message];
                throw error(400, validationError);
            } else {
                cookies.set("token", data.object.token, {
                    path: "/",
                    httpOnly: true,
                    // Session Lifetime
                });
                throw redirect(302, "/");
            }
        } else {
            const validationError = new Error('Validation error');
            (validationError as any).errors = errors;
            throw error(400, validationError);
        }
    }
};

const verifyData = (form: FormData): { isValid: boolean, errors: string[] } => {
    const requiredFields: string[] = ["email", "password"];
    const errors: string[] = [];

    requiredFields.forEach((field) => {
        const value = form.get(field)?.toString().trim();

        if (!value) {
            errors.push(`${field} es requerido`);
        }
    });

    const email = form.get("email")?.toString();
    if (email && !email.includes("@")) {
        errors.push("Email invalido");
    }

    return {
        isValid: errors.length === 0,
        errors
    };
};
