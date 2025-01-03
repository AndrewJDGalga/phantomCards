import { useRef } from 'react'

function SkillFilterButton({col, content}){
    const colID = useRef(col);

    return (
        <button>{content}</button>
    )
}

export default SkillFilterButton