export function SidebarItem({ url, title, svg }) {
  return (
    <a href={url}>
      <div className="h-12 min-h-12 btn w-full">
        {svg} <span>{title}</span>
      </div>
    </a>
  );
}

export default SidebarItem;
