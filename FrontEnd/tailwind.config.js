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
    },
    boxShadow: {
      'custom-inner': 'inset 0 5px 5px 2px rgba(0, 0, 0, 0.2)',
      'custom-outer': '3px 3px 10px 4px rgba(0, 0, 0, 0.25)',
    },
    extend: {},
  },
  plugins: [],
}