import { useState, useEffect, use } from 'react';
import axios from 'axios';
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import PlantCard from './components/PlantCard';
import PlantForm from './components/PlantForm';
import PlantHero from './components/PlantHero';
import PlantNav from './components/PlantNav';
import PlantSearch from './components/PlantSearch';
import PlantLogo from './components/PlantLogo';



function App() {

  const [view, setView] = useState("");

  const[plantToEdit, setPlantToEdit] = useState(null);

  const [plants, setPlants] = useState([])
  useEffect(() => {
    axios.get("http://localhost:8080/api/plants")
      .then(response => {
        setPlants(response.data);
      })
      .catch(error => {
        console.log("Error fetching plants: ", error);
      });
      
  },[] );

  const handleDeletePlant = (id) => {
    axios.delete(`http://localhost:8080/api/plants/${id}`)
      .then(() => {
        const filteredList = plants.filter(plant => plant.id !== id); //esto lo que hace es filtrar la lista y tomar todas las que no tengan el id del parámetro parta actualizar la lista con el id eliminado
        setPlants(filteredList);
      })
      .catch(error =>{
        console.error("Error deleting plant: ", error);
      })
  }

  const handleAddPlant = (newPlant) =>{
    axios.post("http://localhost:8080/api/plants", newPlant)
      .then(response => {
        const updatedList = [
          ... plants,
          response.data
        ]
        setPlants(updatedList);
        console.log("New plant created successfully in H2!");
      })
       .catch(error => {
        console.error("Error creating plant:", error);
      });
  }

  const handleSelectPlant = (plant) => {
    setPlantToEdit(plant);
  }

  const handleUpdatePlant = (updatedPlant) => {
    axios.put(`http://localhost:8080/api/plants/${updatedPlant.id}`, updatedPlant)
      .then(response => {
        const newList = plants.map(plant => plant.id == response.data.id ? response.data : plant);
        setPlants(newList);

        setPlantToEdit(null);
        console.log("Plant updated successfully in H2 Database!");
      })
      .catch(error => {
      console.error("Error updating plant:", error);
      });
  }

  return (
    <>
      <div className="min-h-screen pb-8">
    
        {/* 🌟 LA BARRA SUPERIOR FIJA CON EL MENÚ A LA DERECHA */}
        <div className="bg-luna-card border-b border-magic-green/10 shadow-xs sticky top-0 z-50 w-full">
          
          <div className="w-full px-8 pt-8 flex flex-row justify-end items-center h-16 relative"> 
            
            <PlantLogo onHome={() => setView("")}/>
            
            <PlantNav currentView={view} onViewChange={setView} />

          </div>
        </div>


        <div className="px-4 md:px-8">

          <PlantHero></PlantHero>

          {view === "add" && (
                <PlantForm onAddPlant={handleAddPlant} onEditPlant={handleUpdatePlant} plantData={plantToEdit} ></PlantForm>
            )}
            {view === "list" && (
              <div className="flex flex-wrap justify-center gap-6">
              
              {plants.map(plant => (
                <PlantCard 
                  key={plant.id} 
                  plant={plant} 
                  onDelete={handleDeletePlant} 
                  onEdit={handleSelectPlant}
                />
              ))}

            </div>
            )}

            {view === "search" && (
              <PlantSearch 
                plants={plants} 
                onDelete={handleDeletePlant} 
                onEdit={handleSelectPlant}  
              />

            )}

        </div>

      </div>
        
    </>
  )
}

export default App
