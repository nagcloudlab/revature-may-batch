
const Rx = require('rxjs')
const { filter, map, bufferCount } = require('rxjs/operators')

const subStream = new Rx.Subject()

//--------------------------------------------------------
// producer / publisher e.g Trainer
//--------------------------------------------------------

const trainer = {
    getSubjectsAsync() {
        let i = 0;
        let interval = setInterval(() => {
            i++;
            // if (i === 5) {
            //     console.log(`trainer  : publishing error into stream`)
            //     subStream.error("n/w issue") // // publish / propagate error
            //     clearInterval(interval)
            //     return
            // }
            console.log(`trainer  : publishing sub-${i} into stream`)
            subStream.next(i) // publish / propagate data

            if (i == 12) {
                console.log(`trainer  : completing stream`)
                subStream.complete()
                clearInterval(interval)
            }

        }, 1000)
    }
}


//--------------------------------------------------------
// consumer / Subscriber e.g Employee
//--------------------------------------------------------

const employee1 = {
    doLearn() {
        trainer.getSubjectsAsync()
        subStream
            .pipe(filter(sub => sub % 2 === 0))
            .pipe(map(sub => sub * sub))
            .pipe(bufferCount(2))
            .subscribe({
                next: sub => {
                    console.log(`employee : reacting i.e learing sub ${sub}`)
                },
                error: err => {
                    console.log(`employee : reacting to error ${err}`)
                },
                complete: () => {
                    console.log(`employee : reacting to stream complete`)
                }
            })
    }
}


employee1.doLearn()