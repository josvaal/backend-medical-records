import { useEffect, useState } from "preact/hooks";

export const useSVGImport = ({ name }) => {
  const [loading, setLoading] = useState(false);
  const [svgContent, setSvgContent] = useState("");

  useEffect(() => {
    setLoading(true);

    const importIcon = async () => {
      try {
        const response = await fetch(`/src/assets/icons/${name}.svg`);
        const svgText = await response.text();
        setSvgContent(svgText);
      } finally {
        setLoading(false);
      }
    };

    importIcon();
  }, [name]);

  return {
    loading,
    svgContent,
  };
};
