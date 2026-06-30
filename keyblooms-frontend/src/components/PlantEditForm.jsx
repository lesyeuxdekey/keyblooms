import PlantCard from "./PlantCard";
import PlantForm from "./PlantForm";

function PlantEditForm({plant, handleDeletePlant, handleSelectPlant, handleUpdatePlant}){
    return(
        <>
        <div className="flex flex-col md:flex-row justify-center items-start gap-8 w-full max-w-5xl mx-auto p-4">
                <div className="flex-shrink-0">
                    <PlantCard 
                    key={plant.id} 
                    plant={plant} 
                    onDelete={handleDeletePlant} 
                    onEdit={handleSelectPlant}
                    />
               </div>
                
                <div className="flex-grow w-full">
                    <PlantForm onEditPlant={handleUpdatePlant} plantData={plant} ></PlantForm>
                </div>
            </div>
        </>
    )
}

export default PlantEditForm;