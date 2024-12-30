
function SkillTable({tableHeaders}) {


    return (
    <table>
        <thead>
            <tr>
                {tableHeaders.map(name=>{
                    return (
                        <th>
                            <button>{name}</button>
                        </th>               
                    )
                })}
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    );
}

export default SkillTable