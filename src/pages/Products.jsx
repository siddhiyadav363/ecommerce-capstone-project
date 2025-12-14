import { useEffect, useState } from "react";
import api from "../api/axios";
import ProductCard from "../components/ProductCard";

export default function Products() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    api.get("/api/products")
      .then(res => setProducts(res.data))
      .catch(() => alert("Failed to load products"));
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h2>Products</h2>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {products.map(p => (
          <ProductCard key={p.id} product={p} />
        ))}
      </div>
    </div>
  );
}
