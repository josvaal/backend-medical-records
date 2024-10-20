type MenuItem = {
    path: string;
    text: string;
    icon: string;
    iconSize: number;
};

let menuItems: MenuItem[] = [
    {
        path: '/',
        text: 'Dashboard',
        icon: 'lets-icons:home-duotone',
        iconSize: 30
    },
    {
        path: '/patients',
        text: 'Pacientes',
        icon: 'solar:user-bold-duotone',
        iconSize: 30
    },
    {
        path: '/calendar',
        text: 'Calendario',
        icon: 'solar:calendar-bold-duotone',
        iconSize: 30
    }
];

export { menuItems };