
//-----------------------------------------------------------
// Producer ( e.g Trainer ) Module
//-----------------------------------------------------------
const trainer = {
    getSubject() {
        // 10s
        console.log(`trainer : returning subject`)
        return 1;
    }
}
//-----------------------------------------------------------
// Consumer ( e.g Student ) Module
//-----------------------------------------------------------
const employee = {
    doLearnAndWork() {
        console.log(`employee : requesting subject on trainer`)
        const sub = trainer.getSubject() // pull / sync-call / blocking-call
        console.log(`employee : learning ${sub}`)
        console.log(`employee : working based on subject`)

        console.log(`employee : with mail/other work`)
    }
}
//-----------------------------------------------------------

employee.doLearnAndWork()