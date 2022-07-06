
// cjs or esm
const Rx = require('rxjs')

const doorStream = new Rx.Subject()

//--------------------------------------------------------------
// Room
//--------------------------------------------------------------


// -------------------------------------------------
// Fan
// -------------------------------------------------
const fan = {
    on() {
        console.log("fan on")
    },
    off() {
        console.log("fan off")
    }
}
doorStream.subscribe({
    next: e => {
        if (e.type === "open")
            fan.on()
        if (e.type === "close")
            fan.off()
    }
})

// -------------------------------------------------
// light
// -------------------------------------------------
const light = {
    on() {
        console.log("light on")
    },
    off() {
        console.log("light off")
    }
}

doorStream.subscribe({
    next: e => {
        if (e.type === "open")
            light.on()
        if (e.type === "close")
            light.off()
    }
})

// -------------------------------------------------
// door
// -------------------------------------------------
const door = {
    // listeners: [],
    // addDoorListener(listener) {
    // this.listeners.push(listener)
    // },
    // removeListener(lister) {
    // },
    open() {
        console.log("door opened")
        // this.listeners.forEach(listener => listener.on())
        doorStream.next({ type: 'open' })
    },
    close() {
        console.log("door closed")
        // this.listeners.forEach(listener => listener.off())
        doorStream.next({ type: 'close' })
    }
}
//---------------------------------------------------

// door.addDoorListener(light)
// door.addDoorListener(fan)

//----------------------------------------------------
// setTimeout(() => {
//     door.open();
//     setTimeout(() => {
//         door.close()
//     }, 2000)
// }, 2000)

setInterval(() => {
    door.open()
}, 2000);
setInterval(() => {
    door.close()
}, 3000);


//---------------------------------------------------
