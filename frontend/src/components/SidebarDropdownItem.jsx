export function SidebarDropdownItem({ title, svg, items }) {
  return (
    <div className="dropdown dropdown-bottom w-full">
      <div tabIndex={0} role="button" className="btn m-1 w-full">
        {svg}
        <span>{title}</span>
      </div>
      <ul
        tabIndex={0}
        className="dropdown-content menu bg-base-100 rounded-box z-[1] w-52 p-2 shadow"
      >
        {items.map((item, i) => (
          <li key={i}>
            <a href={item.url}>{item.title}</a>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default SidebarDropdownItem;
