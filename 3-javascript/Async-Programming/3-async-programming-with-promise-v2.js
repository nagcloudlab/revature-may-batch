

// ES6 => Promise API

// Es7 =>  Async , Await   , to avoid callback hells while working promises

//-----------------------------------------------------------
// Producer ( e.g Trainer ) Module
//-----------------------------------------------------------
const trainer = {
    getSubjectAsync() {
        const promise = new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log(`trainer  : resolving promise`)
                resolve(11)
                // console.log(`trainer  : rejecting promise`)
                // reject("oops")
            }, 3000);
        })
        return promise
    }
}


//-----------------------------------------------------------
// Producer ( e.g Manager ) Module
//-----------------------------------------------------------
const manager = {
    getWorkAsync(sub) {
        const promise = new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log(`manager  : resolving promise`)
                resolve(`${sub}-work`) // push
            }, 1000);
        })
        return promise
    }
}

//-----------------------------------------------------------
// Consumer ( e.g Student ) Module
//-----------------------------------------------------------
const employee = {
    async doLearnAndWork() {
        try {
            console.log(`employee : requesting subject on trainer`)
            const sub = await trainer.getSubjectAsync()
            const enrichedSub = sub * 10
            console.log(`employee : learning subject ${enrichedSub}`)
            console.log(`employee : requesting work on manager`)
            const work = await manager.getWorkAsync(enrichedSub)
            console.log(`employee : working on ${work}`)
        }
        catch (e) {
            console.log(`employee : handling sub/work error ${err}`)
        }
    },
    doSomething() {
        this.doLearnAndWork()
        console.log(`employee : with mail/other work`)
    }
}
//-----------------------------------------------------------
employee.doSomething()