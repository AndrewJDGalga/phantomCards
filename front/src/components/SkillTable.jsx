
function SkillTable({tableHeaders}) {


    return (
    <table>
        <thead>
            <tr>
                {tableHeaders.map(name=>
                    <th key={name}>
                        <button>{name}</button>
                    </th>
                )}
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    );
}

export default SkillTable