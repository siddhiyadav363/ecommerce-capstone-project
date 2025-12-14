import { useState } from "react";
import api from "../api/axios";

const TEMP_USER_ID = "e1f7a8c2-9a6b-4c1a-8a0d-123456789abc";

export default function ProductCard({ product }) {
  const [qty, setQty] = useState(1);

  const placeOrder = async () => {
    try {
      await api.post(
        `/api/orders?userId=${TEMP_USER_ID}&productId=${product.id}&quantity=${qty}`
      );
      alert("Order placed successfully");
    } catch {
      alert("Order failed");
    }
  };

  return (
    <div style={styles.card}>
      <h3>{product.name}</h3>
      <p>₹{product.price}</p>

      <div>
        <button onClick={() => setQty(q => Math.max(1, q - 1))}>−</button>
        <span style={{ margin: "0 10px" }}>{qty}</span>
        <button onClick={() => setQty(q => q + 1)}>+</button>
      </div>

      <br />
      <button onClick={placeOrder}>Place Order</button>
    </div>
  );
}

const styles = {
  card: {
    border: "1px solid #ddd",
    padding: 20,
    margin: 10,
    width: 200,
    textAlign: "center"
  }
};
