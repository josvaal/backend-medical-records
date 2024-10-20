<script lang="ts">
	import FullCalendar, { type CalendarOptions, type EventInput } from 'svelte-fullcalendar';
	import daygridPlugin from '@fullcalendar/daygrid';
	import interactionPlugin from '@fullcalendar/interaction';
	import timegridPlugin from '@fullcalendar/timegrid';

	let events: EventInput[] = [{ title: 'Reserva de Endodoncia', start: new Date() }];

	let options: CalendarOptions = {
		firstDay: 1,
		initialView: 'dayGridMonth',
		locale: 'es',
		plugins: [daygridPlugin, interactionPlugin, timegridPlugin],
		selectable: true,
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		dateClick: (event: { dateStr: string }) => alert('se le dio click ' + event.dateStr),
		events
	};
</script>

<svelte:head>
	<title>Calendario</title>
</svelte:head>

<main class="h-full overflow-y-auto">
	<div class="container mx-auto grid px-6 text-gray-700 dark:text-gray-200">
		<h2 class="my-6 text-2xl font-semibold">Calendario</h2>

		<FullCalendar {options} />
	</div>
</main>
