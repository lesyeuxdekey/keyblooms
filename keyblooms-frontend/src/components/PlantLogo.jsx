import realLogo from "../logo-keyblooms.png";

function PlantLogo({onHome}) {
   return (
    <div 
      onClick={onHome}
      className="absolute top-14 left-4 -translate-y-1/2 z-50 transition-transform duration-300 hover:scale-105 cursor-pointer"
    >      
      <img 
        src={realLogo} 
        alt="KeyBlooms Logo" 
        style={{ width: "100px", height: "150px" }} 
        className="object-contain block"
      />

    </div>
  );
}


export default PlantLogo;
