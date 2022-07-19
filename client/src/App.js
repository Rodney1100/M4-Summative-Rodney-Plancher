import GamesItem from './Components/GameComponents/GamesItem.js';

import ShirtItem from './Components/ShirtComponents/ShirtItem.js';
import ConsoleItem from './Components/ConsoleComponents/ConsoleItem.js';

function App() {
  return (
    <main className="container">
      <ConsoleItem/>
      <ShirtItem/>
      <GamesItem/>
    </main>
  );
}


export default App;
