

import { Observable } from 'rxjs'
import { filter, bufferCount } from 'rxjs/operators'

//---------------------------------------------------
// Trainer Module ( dependency ) - publisher
//---------------------------------------------------

let trainer = {
    getSubjectAsync() {
        const promise = new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log("trainer- resolving promise..");
                resolve("JAVA") // pushing data
            }, 3000)
        });
        return promise;
    },
    getSubjectsAsync() {
        const stream = Observable.create((e: any) => {
            let subIdx = 0;
            let interval = setInterval(() => {
                if (subIdx === 10) {
                    clearInterval(interval);
                    e.complete(); // closing stream
                    return
                }
                subIdx++;
                // if (subIdx == 5)
                //     e.error('oops')
                console.log('trainer - publishing new event/change into stream');
                e.next(subIdx)
            }, 1000)
        });
        return stream;
    }
}

//---------------------------------------------------
// Employee Module ( dependent )
//---------------------------------------------------

let employee = {
    doLearnAndWork() {

        // let promise = trainer.getSubjectAsync() // async
        // promise
        //     .then(subject => {
        //         console.log("employee - learning " + subject);
        //         console.log("employee working...");
        //     })


        const stream = trainer.getSubjectsAsync();
        stream
            .pipe(filter((sub: number) => sub % 2 === 0))
            .pipe(bufferCount(2))
            .subscribe({
                next: (subject: number) => console.log("employee - reacting/learning subject-" + subject),
                error: (error: any) => console.log("employee - reacting to an error"),
                complete: () => {
                    console.log("employee - thanks traininer for many subjects")
                }
            })


    }
}



employee.doLearnAndWork();
