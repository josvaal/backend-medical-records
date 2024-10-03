import { useSVGImport } from "../hooks/useSVGImport";

export default function IconComponent({ iconName }) {
  const { loading, svgContent } = useSVGImport({ name: iconName });

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div
      className="icon"
      dangerouslySetInnerHTML={{ __html: svgContent }}
      style={{ display: "inline-block", width: "24px", height: "24px" }}
    />
  );
}
