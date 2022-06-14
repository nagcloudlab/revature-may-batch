
// dependent

import { getSubject, getSubjectAsync } from './trainer'


export function doLearnAndWork() {

    console.log("employee started to learn");
    console.log("employee requesting subject on trainer");
    const promise = getSubjectAsync() // async call
    console.log("employee got promise from trainer");
    console.log("employee defering learning actions to future with promise");

    promise
        .then(subject => { console.log("employee learning " + subject); })
        .catch(error => console.log("employee reacting to error " + error))
        .finally(() => {
            console.log("finally");
        })

    console.log("employee with other work...if");

}