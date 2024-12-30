import { useState } from 'react'
import '../styling/index.css'
import SkillTable from './SkillTable';

const testObjects = [
  {
    id : 1,
    name : "Psycho Wave",
    type : "Attack",
    school : "Psycho",
    cost : "4",
    str : "x",
    use : "1",
    range : "short",
    homing : "4",
    desc : "STR = target's Level"
  },
  {
    id : 87,
    name : "Flash Barrier",
    type : "Defense",
    school : "Optical",
    cost : "0",
    str : "2",
    use : "∞",
    range : "self",
    homing : "1",
    desc : "[Barrier]"
  },
  {
    id : 157,
    name : "Wind Pressure",
    type : "Erase",
    school : "Nature",
    cost : "3",
    str : "-",
    use : "1",
    range : "medium",
    homing : "2",
    desc : "Erases all of target's equipped non-attack and non-defensive skills."
  },
  {
    id : 224,
    name : "Fatigue",
    type : "Environment",
    school : "Ki",
    cost : "2",
    str : "-",
    use : "1",
    range : "env",
    homing : "1",
    desc : "Everyone's Aura recovery ceases while moving."
  },
  {
    id : 290,
    name : "Trance",
    type : "Status",
    school : "Faith",
    cost : "0",
    str : "-",
    use : "∞",
    range : "self",
    homing : "2",
    desc : "Increases damage of your attacks by 2 for 15 sec. Penalty: 1 Health."
  },
]

const testHeaders = ['ID','NAME','TYPE','SCHOOL','COST','STR','USE','RANGE','HOMING', 'DESCRIPTION'];


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1>TODO: Table</h1>
      <SkillTable tableHeaders={testHeaders} tableRows={testObjects}></SkillTable>
    </>
  )
}

export default App
