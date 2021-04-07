using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class wan_ro : MonoBehaviour {
    public GameObject flare_wall;
    Vector3 fi_s= new Vector3(080.24f, 53.417f, 62.478f);
    Vector3 wan_arri = new Vector3(250.93f,53.23f,62.43f);
    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        
		
	}
    private void OnTriggerEnter(Collider other)
    {
        if (other.tag == "Player")
        {
            flare_wall.SetActive(true);
            
        }
    }
    //private void OnTriggerStay(Collider other)
    //{
    //    if (other.tag == "Player")
    //    {
    //        if (flare_wall == true)
    //        {
    //            flare_wall.transform.position = Vector3.MoveTowards(flare_wall.transform.position, wan_arri, Time.deltaTime * 1.5f);
    //        }
    //    }
    //}

}
