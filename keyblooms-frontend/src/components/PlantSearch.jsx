import { useState } from "react";
import PlantCard from "./PlantCard";


function PlantSearch({  plants, onDelete, onEdit}) {
  const [searchTerm, setSearchTerm] = useState("");

  // 1. Aquí se declara la constante (Revisa que el nombre use la P mayúscula)
  const filteredPlants = plants.filter((plant) => {
    if (searchTerm === "") {
    return false;
    } 
    return plant.name.toLowerCase().includes(searchTerm.toLowerCase());
  });

  // 2. RECIÉN AQUÍ ABAJO EMPIEZA EL RETURN
  return (
    <div className="text-center animate-fade-in">
      <h2 className="boho-title text-4xl mb-4">Divination Search Engine</h2>
      
      <input 
        type="text" 
        className="boho-search-input text-center" 
        value={searchTerm} 
        onChange={(e) => setSearchTerm(e.target.value)} 
      />

      <p className="text-luna-mustard italic mt-4">
        Plants found by spell: {filteredPlants.length}
      </p>

      <div className="flex flex-wrap justify-center gap-6 mt-6">
        {filteredPlants.map(plant => (
            <PlantCard 
              key={plant.id} 
              plant={plant} 
              onDelete={onDelete} 
              onEdit={onEdit}
            />
          ))}
      </div>

    </div>
  );
}


export default PlantSearch;
