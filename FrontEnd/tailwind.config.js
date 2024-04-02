/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    colors:{
      bluegray:'#CAD4E4'
      ,lightpink:'#FFC5CD'
      ,floralwhite:'#FFFAF0'
      ,red:'#EC0200'
    },
    boxShadow: {
      'custom-inner': 'inset 0 5px 5px 2px rgba(0, 0, 0, 0.2)',
      'custom-outer': '3px 3px 10px 4px rgba(0, 0, 0, 0.25)',
    },
    extend: {},
  },
  plugins: [require("daisyui"),
    ({ addUtilities }) => {
      addUtilities({
        ".gray-button": {
          "@apply bg-bluegray rounded-3xl shadow-custom-outer  p-2 w-[55%] mx-auto my-[5%] active:scale-90 duration-300":
              "",
        },
        ".pink-button": {
          "@apply bg-lightpink rounded-3xl shadow-custom-outer  p-2 w-[55%] mx-auto my-[5%] active:scale-90 duration-300":""
        }
      });
    },
  ],
}