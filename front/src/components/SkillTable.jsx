
function SkillTable({tableHeaders, tableRows}) {
    const headers = tableHeaders.map(name=>
        <th key={name}>
            {(name !== "DESCRIPTION") && <button>{name}</button>}
            {(name === "DESCRIPTION") && <th>{name}</th>}
        </th>
    );

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