const apiOrigin = import.meta.env.VITE_API_ORIGIN;

type UserRole = 'DOCTOR' | 'PATIENT';

const authVerify = async (cookieToken: string) => {
    const url = `${apiOrigin}/auth/verifyLogin`;
    const options = {
        method: 'POST',
        headers: {
            Authorization: `Bearer ${cookieToken}`
        }
    };

    try {
        const response = await fetch(url, options);
        const data = await response.json();
        return data
    } catch (error) {
        console.error(error);
        return JSON.stringify(error)
    }
}

const authLogin = async (email: string, password: string) => {
    const url = `${apiOrigin}/auth/login`;
    const options = {
        method: 'POST',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({
            email,
            password
        })
    };
    try {
        const response = await fetch(url, options);
        const data = await response.json();
        return data
    } catch (error) {
        console.error(error);
        return JSON.stringify(error);
    }
}

const authRegister = async (firstname: string, lastname: string, email: string, password: string, dateOfBirth: string, phone: string, address: string) => {
    const url = `${apiOrigin}/auth/register`;
    const options = {
        method: 'POST',
        headers: { 'content-type': 'application/json' },
        body: JSON.stringify({
            firstname,
            lastname,
            email,
            password,
            userRole: 'PATIENT',
            dateOfBirth: new Date(dateOfBirth),
            phone,
            address
        })
    };

    try {
        const response = await fetch(url, options);
        const data = await response.json();
        return data;
    } catch (error) {
        return JSON.stringify(error);
    }
}

export { authLogin, authRegister, authVerify }