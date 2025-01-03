import { useState } from "react";
import SkillFilterButton from "./SkillFilterButton";

function SkillTable({tableHeaders, tableRows}) {
    const [column, setColumn] = useState(0);
    const [ascending, setAscending] = useState(true);
    
    const headers = [];
    for(let i = 0; i < tableHeaders.length; i++){
        headers.push(
            <th key={tableHeaders[i]}>
            {(tableHeaders[i] !== "DESCRIPTION") && <SkillFilterButton col={i} content={tableHeaders[i]}></SkillFilterButton>}
            {(tableHeaders[i] === "DESCRIPTION") && <th>{tableHeaders[i]}</th>}
        </th>
        );
    }
    const rows = tableRows.map(row=>
        <tr key={row.id}>
            <td>{row.id}</td>
            <td>{row.name}</td>
            <td>{row.type}</td>
            <td>{row.school}</td>
            <td>{row.cost}</td>
            <td>{row.str}</td>
            <td>{row.use}</td>
            <td>{row.range}</td>
            <td>{row.homing}</td>
            <td>{row.desc}</td>
        </tr>
    );

    return (
    <table>
        <thead>
            <tr>
                {headers}
            </tr>
        </thead>
        <tbody>
            {rows}
        </tbody>
    </table>
    );
}

export default SkillTable