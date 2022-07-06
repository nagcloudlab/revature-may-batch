

// ES6 => Promise API

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
    doLearnAndWork() {
        console.log(`employee : requesting subject on trainer`)
        const promise = trainer.getSubjectAsync()
        console.log(`employee : received promise, defer actions to future`)
        promise
            .then(sub => {
                return sub * 10
            })
            .then(enrichedSub => {
                console.log(`employee : learning subject ${enrichedSub}`)
                const promise = manager.getWorkAsync(enrichedSub)
                promise
                    .then(work => {
                        console.log(`employee working on ${work}`)
                    })
                    .catch(err => {
                        console.log(`employee : handling work error ${err}`)
                    })
            })
            .catch(err => {
                console.log(`employee : handling sub error ${err}`)
            })
        console.log(`employee : with mail/other work`)
    }
}
//-----------------------------------------------------------
employee.doLearnAndWork()