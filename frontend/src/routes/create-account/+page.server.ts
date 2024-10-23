import { authRegister } from '$lib/database/auth.js';
import { redirect, error } from '@sveltejs/kit';

/** @type {import('./$types').Actions} */
export const actions = {
	default: async ({ request, cookies }) => {
		const formData = await request.formData();

		const { isValid, errors } = verifyData(formData)

		if (isValid) {
			const data = await authRegister(
				formData.get("firstname")?.toString() ?? "",
				formData.get("lastname")?.toString() ?? "",
				formData.get("email")?.toString() ?? "",
				formData.get("password")?.toString() ?? "",
				formData.get("dateOfBirth")?.toString() ?? "",
				formData.get("phone")?.toString() ?? "",
				formData.get("address")?.toString() ?? ""
			);
			if (data.object == null) {
				const validationError = new Error('Validation error');
				(validationError as any).errors = [data.message];
				throw error(400, validationError);
			} else {
				cookies.set("token", data.object.token, {
					path: "/",
					httpOnly: true
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
	const requiredFields: string[] = ["firstname", "lastname", "email", "address", "password", "repeat_password", "dateOfBirth", "phone"];
	const errors: string[] = [];

	requiredFields.forEach((field) => {
		const value = form.get(field)?.toString().trim();

		if (!value) {
			errors.push(`${field} es requerido`);
		}
	});

	const password = form.get("password")?.toString();
	const repeatPassword = form.get("repeat_password")?.toString();
	if (password !== repeatPassword) {
		errors.push("Las contraseñas no coinciden");
	}

	const email = form.get("email")?.toString();
	if (email && !email.includes("@")) {
		errors.push("Email invalido");
	}

	const dateOfBirth = new Date(form.get("dateOfBirth")?.toString() || '');
	if (isNaN(dateOfBirth.getTime())) {
		errors.push("Fecha de nacimiento invalido");
	}

	const phone = form.get("phone")?.toString();
	if (phone && !/^\d{9}$/.test(phone)) {
		errors.push("El nro. de celuar tiene que tener 9 digitos como maximo");
	}

	return {
		isValid: errors.length === 0,
		errors
	};
};
