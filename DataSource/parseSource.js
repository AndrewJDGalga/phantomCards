import fs from 'node:fs';

fs.readFile('skillsRaw.txt', 'utf8', (err, data) => {
    if (err) {
        console.error(err);
        return;
    }
    console.log(data);
});