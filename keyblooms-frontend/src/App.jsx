import { useState, useEffect, use } from 'react';
import axios from 'axios';
import './App.css'
import PlantCard from './components/PlantCard';
import PlantForm from './components/PlantForm';
import PlantHero from './components/PlantHero';
import PlantNav from './components/PlantNav';
import PlantSearch from './components/PlantSearch';
import PlantLogo from './components/PlantLogo';
import PlantEditForm from './components/PlantEditForm';



function App() {

  const [view, setView] = useState("hero");

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
    setView("edit");
  }

  const handleUpdatePlant = (updatedPlant) => {
    axios.put(`http://localhost:8080/api/plants/${updatedPlant.id}`, updatedPlant)
      .then(response => {
        const newList = plants.map(plant => plant.id == response.data.id ? response.data : plant);
        setPlants(newList);

        setPlantToEdit(null);
        setView("list");
        console.log("Plant updated successfully in H2 Database!");
      })
      .catch(error => {
      console.error("Error updating plant:", error);
      });
  }

  return (
    <>
      <div className="min-h-screen pb-8">
    
        <div className="bg-luna-card border-b border-magic-green/10 shadow-xs sticky top-0 z-50 w-full">
          
          <div className="w-full px-8 pt-8 flex flex-row justify-end items-center h-16 relative"> 
            
            <PlantLogo onHome={() => setView("hero")}/>
            
            <PlantNav currentView={view} onViewChange={setView} />

          </div>
        </div>


        <div className="px-4 md:px-8">

          {view === "hero" && (
            <PlantHero></PlantHero>
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

          {view === "edit" && plantToEdit && (
            <div className="mt-10">
              <h2 className="boho-title text-4xl text-center mb-4">Edit Plant</h2>
              <PlantEditForm 
                plant={plantToEdit}
                handleDeletePlant={handleDeletePlant}
                handleSelectPlant={handleSelectPlant}
                handleUpdatePlant={handleUpdatePlant}
              />
            </div>          
          )}

          {view === "add" && (
            <div>
                <h2 className="boho-title text-4xl text-center mb-4 mt-10">Add a new plant</h2>
                <PlantForm onAddPlant={handleAddPlant} onEditPlant={handleUpdatePlant} plantData={plantToEdit} ></PlantForm>
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
