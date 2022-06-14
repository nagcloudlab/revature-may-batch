
// dependency

export function getSubject() {
    // 10s
    return "fullstack"
}

export function getSubjectAsync() {

    const promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            const subject = "FULLSTACK"

            console.log("trainer resolving promise");
            resolve(subject) // push

            // console.log("trainer rejecting promise");
            // reject("no subject")

        }, 5000);
    });

    return promise;
}