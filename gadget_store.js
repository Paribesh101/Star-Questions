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

  // ===== Part 2: Updates =====

// Add a category with $set
db.products.updateOne(
    { name: "Wireless Mouse" },
    { $set: { category: "Accessories" } }
  );
  
  // Increase price by 15 with $inc
  db.products.updateOne(
    { name: "Wireless Mouse" },
    { $inc: { price: 15 } }
  );
  
  // Add tags with $push
  db.products.updateOne(
    { name: "Wireless Mouse" },
    { $push: { tags: "wireless" } }
  );
  
  db.products.updateOne(
    { name: "Wireless Mouse" },
    { $push: { tags: "bestseller" } }
  );

  // Remove "wireless" with $pull
db.products.updateOne(
    { name: "Wireless Mouse" },
    { $pull: { tags: "wireless" } }
  );

  // ===== Part 2: Queries =====

// Products priced at or above 100
db.products.find({ price: { $gte: 100 } });

// Products by brand, using dot notation
db.products.find({ "specs.brand": "Logitech" });

// Products whose category is in a list
db.products.find({ category: { $in: ["Accessories", "Computers"] } });

// ===== Part 3: Orders and the join =====

// Link an order to a product by its _id
const mouse = db.products.findOne({ name: "Wireless Mouse" });

db.orders.insertOne({
  productId: mouse._id,
  quantity: 2
});

// Join orders to products and output a clean receipt
db.orders.aggregate([
  {
    $lookup: {
      from: "products",
      localField: "productId",
      foreignField: "_id",
      as: "product"
    }
  },
  { $unwind: "$product" },
  {
    $project: {
      _id: 0,
      productName: "$product.name",
      quantity: 1
    }
  }
]);