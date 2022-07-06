
// const revatureGreet = require('revature-may-batch-greet') // cjs
import revatureGreet from 'revature-may-batch-greet' // esm
// const lodash = require('lodash') // cjs
import lodash from 'lodash' // esm
// require('./index.scss') // cjs
import './index.scss' // esm

// const { item } = require('./menu') // cjs
// import { item1 as one, item2 as two } from './menu' // esm
// console.log(one)
// console.log(two)

// import * as items from './menu'
// console.log(items.item1)
// console.log(items.item2)

import mItem, { item1, item2 } from './menu'
console.log(mItem)


let lang = "ar";
revatureGreet(lang)

let arr1 = [1, 2, 3, 7]
let arr2 = [3, 4, 5, 6]

let arr = lodash.difference(arr1, arr2);
console.log(arr)