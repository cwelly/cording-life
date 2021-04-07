using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class fe_able : MonoBehaviour {
    public GameObject cube,doe;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
         
    }
    void OnTriggerStay(Collider col)
    {
        if (col.tag == "Play")
        {
           
            if (Input.GetKeyDown(KeyCode.E))
            {
                doe.SetActive(false);
                cube.SetActive(true);
                
            }
            else if (Input.GetKeyDown(KeyCode.Q) && cube == true)
            {
                doe.SetActive(true);
            }
        }
    }
}
