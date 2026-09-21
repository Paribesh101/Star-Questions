db = db.getSiblingDB("gadgetStore");

db.createCollection("products", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["name", "price", "inStock"],
      properties: {
        name:    { bsonType: "string" },
        price:   { bsonType: ["int", "double"] },
        inStock: { bsonType: "bool" },
        specs: {
          bsonType: "object",
          properties: {
            brand: { bsonType: "string" }
          }
        }
      }
    }
  }
})

db.products.insertMany([
    {
      name: "Wireless Mouse",
      price: 29.99,
      inStock: true,
      specs: { brand: "Logitech" }
    },
    {
      name: "Laptop",
      price: 300.00,
      inStock: false,
      specs: { brand: "HP" }
    },
    {
      name: "PC",
      price: 1600,
      inStock: true,
      specs: { brand: "Aurora" }
    }
  ]);

  // Validation test 1: missing price — should fail
db.products.insertOne({
    name: "Gaming Headset",
    inStock: true,
    specs: { brand: "Razer" }
  });
  
  // Validation test 2: price is a string — should fail
  db.products.insertOne({
    name: "Webcam",
    price: "fifty",
    inStock: true,
    specs: { brand: "Logitech" }
  });