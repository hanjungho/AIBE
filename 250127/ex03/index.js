const obj = { name: "kim", age: 15 };
console.log(obj);
console.log(obj.name);
console.log(obj.age);
console.log(Object.keys(obj));
console.log(Object.values(obj));
console.log(Object.assign(obj));
console.log(Object.entries(obj));

const objk = Object.keys(obj);
for (let index = 0; index < objk.length; index++) {
  const element = objk[index];
  console.log("element", element);
}

for (const v of objk) {
  //   const element = objk[index];
  //   console.log(objk[index]);
  console.log("v", v);
}

for (const key in obj) {
  console.log(key, obj[key]);
}
